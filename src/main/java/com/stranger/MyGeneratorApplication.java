package com.stranger;

import com.stranger.common.config.GenConfig;
import com.stranger.domain.GenTable;
import com.stranger.domain.GenTableData;
import com.stranger.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.io.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipOutputStream;

@SpringBootApplication
public class MyGeneratorApplication implements ApplicationRunner {

    @Autowired(required=true)
    private GenService genService;

    public static void main(String[] args) {
        SpringApplication.run(MyGeneratorApplication.class, args);
    }

    private void generatorTable() {
        try {
            List<GenTable> genTables = genService.selectDbTableList();
            List<GenTableData> genTableData = genService.buildTableInfo(genTables);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream(outputStream);
            genService.generatorCode(genTableData, zip);
            IOUtils.closeQuietly(zip);
            FileOutputStream fileOutputStream = new FileOutputStream(GenConfig.fileDownLoadPath);
            fileOutputStream.write(outputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            System.err.println("<=================代码已经生成=================>");
                    System.exit(0);
        } catch (Throwable ex) {
//            throw ex;
        }
    }

    public void run(ApplicationArguments args) throws IOException {
        generatorTable();
    }
}
