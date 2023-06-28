package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String fileName) {
        return fileDir + fileName;
    }


    // 여러개 업로드
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!(multipartFile.isEmpty())) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }

        return storeFileResult;
    }


    // 하나만 업로드
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFileName = multipartFile.getOriginalFilename();
        // image.png

        // 서버에 저장하는 파일명
        String storeFileName = createStoreFileName(originalFileName);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));


        return new UploadFile(originalFileName, storeFileName);
    }


    private static String createStoreFileName(String originalFileName) {
        // 서버에 저장하는 파일명, 다만 사용자가 업로드한 파일의 확장자만 가져오기
        String uuid = UUID.randomUUID().toString();
        // png를 추출
        String ext = extractExt(originalFileName);
        // xxxxx.png
        return uuid + "." + ext;
    }

    private static String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }


}
