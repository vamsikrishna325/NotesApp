import java.io.*;
import java.util.*;

public class Notes{
    private static final String fileName = "notes.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1. Write Note\n2. View Notes\n3. Remove Note\n4. Exit");
            System.out.println();
            System.out.print("Enter Option = ");
            ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.print("Enter your note: ");
                String note = sc.nextLine();
                try {
                    FileWriter fw = new FileWriter(fileName, true);
                    fw.write(note + "\n");
                    fw.close();
                    System.out.println("Note saved.");
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (ch == 2) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileName));
                    String line;
                    int i = 1;
                    while ((line = br.readLine()) != null) {
                        System.out.println(i + ". " + line);
                        i++;
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (ch == 3) {
                ArrayList<String> notes = new ArrayList<>();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileName));
                    String line;
                    while ((line = br.readLine()) != null) {
                        notes.add(line);
                    }
                    br.close();
                    if (notes.isEmpty()) {
                        System.out.println("No notes to remove.");
                    } else {
                        for (int i = 0; i < notes.size(); i++) {
                            System.out.println((i + 1) + ". " + notes.get(i));
                        }
                        System.out.print("Enter note number to remove: ");
                        int idx = sc.nextInt();
                        sc.nextLine();
                        if (idx >= 1 && idx <= notes.size()) {
                            notes.remove(idx - 1);
                            FileWriter fw = new FileWriter(fileName, false);
                            for (String s : notes) {
                                fw.write(s + "\n");
                            }
                            fw.close();
                            System.out.println("Note removed.");
                        } else {
                            System.out.println("Invalid number.");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } while (ch != 4);
        sc.close();
    }
}

