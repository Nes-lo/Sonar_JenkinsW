package com.neslo.semillero.counter;

import com.neslo.semillero.model.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCounterDefaultTest {
    private WordCounter wordCounter;
    private String absolutePath;
    @BeforeEach
    //Preparacion de la prueba
    public void setup(){
        Path resourceDirectory= Paths.get("src","test","resources");
                absolutePath=resourceDirectory.toFile().getAbsolutePath();
        wordCounter=new WordCounterDefault();

    }
    @Test

    void mustReturnCorrectSummary() throws IOException {

      //Ejecuccion de la prueba
       Summary summary=wordCounter.process(absolutePath+ File.separator + "test.txt");
      //Verificaicon de la prueba
       Assertions.assertEquals(2,summary.getNumberOfLines());
       Assertions.assertEquals(5,summary.getNumberOfWord());

    }

    void mustThrowsIOExceptionWhenFileNotFound() throws IOException{
        IOException thrown = assertThrows(
                IOException.class,
                ()->{
                    Summary summary=wordCounter.process(absolutePath+File.separator+"test.txt");
                }
        );

        assertNotNull(thrown.getMessage());
    }

}
