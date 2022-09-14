package com.neslo.semillero.counter;

import com.neslo.semillero.model.Summary;

import java.io.IOException;

public interface WordCounter {
    Summary procecc(String pathFile) throws IOException;
}
