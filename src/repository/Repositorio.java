package repository;

import exception.ObjetoNaoAlteravelException;

import java.io.*;
import java.util.List;

public interface Repositorio<T> {

    T find(String key);

    void update(T item) throws ObjetoNaoAlteravelException;

    void add(T item);

    void delete(T item);

    default void loadData(String arquivo, List<T> lista) {

        File file = new File(arquivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
                return;
            }
        }

        if (file.length() == 0) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            lista.clear();
            lista.addAll((List<T>) ois.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }

    }

    default void saveData(String arquivo, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

}
