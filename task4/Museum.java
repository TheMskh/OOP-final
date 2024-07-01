package finalexam.task4;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Museum implements LegalEntity {
    public final String name;
    public String vatNumber;
    public String address;
    public final List<Artifact> products = new ArrayList<>();

    public Museum(String name, String vatNumber, String address) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addProduct(Artifact product) {
        products.add(product);
    }

    public boolean deleteProduct(Artifact product) {
        for (Artifact p : products) {
            if (p.equals(product)) {
                products.remove(p);
                return true;
            }
        }

        return false;
    }

    public List<Artifact> getProducts() {
        return products;
    }

    public void saveState() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("task4/products.txt"));
            for (Artifact p : products) {
                writer.write(p.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadState() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("task4/products.txt"));
            products.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                products.add(new Artifact(parts[0], Double.parseDouble(parts[1])));
            }
            reader.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}