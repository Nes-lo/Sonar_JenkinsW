package com.neslo.semillero.counter;

import com.neslo.semillero.model.Summary;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;

public class WordCounterDefault implements WordCounter{
    @Override
    public Summary procecc(String pathFile) throws IOException {

        Path path = Paths.get(pathFile);
        long numberOfLines = getNumberOfLines(path);
        long numberOfWords = getNumberOfWords(path);


        return new Summary(numberOfLines,numberOfWords);
    }

    private long getNumberOfWords(Path path) throws IOException {

        try(Stream<String> lines= Files.lines(path)){
            return lines
                    .map(l->l.split(""))
                    .mapToInt(wordsOfLine->wordsOfLine.length)
                    .sum();
        }

    }

    private long getNumberOfLines(Path path) throws IOException {
        try(Stream<String> lines= Files.lines(path)){
            return lines.count();
        }

    }
}

