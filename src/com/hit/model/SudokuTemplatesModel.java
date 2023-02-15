package com.hit.model;
import com.hit.client.Client;
import com.hit.client.SudokuTemplate;

import java.io.IOException;
import java.util.List;

public class SudokuTemplatesModel implements Model{

    Client client = new Client();

    public SudokuTemplate getTemplateByDifficulty(String difficulty) throws IOException {
        return client.getTemplateByDifficulty(difficulty);
    }

    public SudokuTemplate handleSolveSudoku(SudokuTemplate sudokuTemplate) throws IOException {
        return client.handleSolveSudoku(sudokuTemplate);
    }

    public List<SudokuTemplate> getAllTemplates() throws IOException {
        return client.getAllTemplates();
    }

    public void deleteByID(String id) throws IOException {
        client.deleteByID(id);
    }

}
