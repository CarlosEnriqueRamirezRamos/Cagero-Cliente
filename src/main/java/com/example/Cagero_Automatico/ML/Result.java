package com.example.Cagero_Automatico.ML;

import java.util.List;

public class Result<T> {
    public boolean correct;
    public String errorMessage;
    public Exception ex;
    public T object;       // para un solo objeto o lista, depende de T
    public List<T> objects; // aquí List<T> puede complicar las cosas
}

