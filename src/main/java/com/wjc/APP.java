package com.wjc;

import com.wjc.domain.Sale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class APP {
    public APP() {
        try {
            String fileName="D:\\Projects\\java\\POS\\src\\main\\java\\com\\wjc\\files\\supermarket.txt";
            File file=new File(fileName);

            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String name=bufferedReader.readLine();
            switch (name)
            {
                case "Hongqi":
                case "Hualian":
                    new Sale(name);
                default:break;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new APP();
    }
}
