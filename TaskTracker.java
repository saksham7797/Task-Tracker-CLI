
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTracker {

    // Progress Updater Function
    public void update_prog(int id, String progress) {
        List<Task> tsk = loadData();
        
        try {
            for (int i = 0; i < tsk.size(); i++) {
                if(id == tsk.get(i).id) {
                    tsk.get(i).progress = progress;
                }
            }
            fileWriting(tsk);
        } catch (Exception e) {
            System.out.println("Id doesn't Exists.");
        }
    }

    // File Writer Helper Function
    public void fileWriting(List<Task> tsk) {
        File f = new File("Tasks.json");
        if(f.exists()) {
            try(FileWriter writer = new FileWriter("Tasks.json")){
                String braces_o = "[";
                String braces_c = "]";
                
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < tsk.size(); i++) {
                    ans.append("{\n").append("\"id\":").append(tsk.get(i).id).append(",");

                    ans.append("\n").append("\"description\":").append("\"").append(tsk.get(i).desc).append("\"").append(",");
                    
                    ans.append("\n").append("\"progress\":").append("\"").append(tsk.get(i).progress).append("\"").append(",");
                    
                    ans.append("\n").append("\"timeCreated\":").append("\"").append(tsk.get(i).timeCreated).append("\"").append(",");
                    
                    ans.append("\n").append("\"timeUpdated\":").append("\"").append(tsk.get(i).timeUpdated).append("\"");
                    
                    ans.append("\n").append("}");
                    if(i != tsk.size()-1) {
                        ans.append(",");
                        ans.append("\n");
                    }
                }
                writer.write(braces_o);
                writer.write(ans.toString());
                writer.write(braces_c);
    
            }catch(Exception e) {
                System.out.println("Unable to Write in file.");
            }
        } else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create Tasks");
            }
        }
        
    }

    // Updating Task Description
    public void update_desc(int id, String desc) {
        List<Task> tsk = loadData();
        try {
            for (int i = 0; i < tsk.size(); i++) {
                if(tsk.get(i).id == id) {
                    tsk.get(i).desc = desc;
                }
            }
            fileWriting(tsk);
        } catch (Exception e) {
            System.out.println("Id doesn't exist.");
        }
    }


    // Deleting Task Function
    public void delete(int id) {
        List<Task> tsk = loadData();
        try {
            for (int i = 0; i < tsk.size(); i++) {
                if(tsk.get(i).id == id) {
                    tsk.remove(i);
                }
            }
            fileWriting(tsk);
        } catch (Exception e) {
            System.out.println("Id doesn't exist.");
        }
    }

    /*
        File Loading/Reading is done and a List<Task> is generated with proper data.
    */

    // To show the contents of file
    @Override
    public String toString() {
        List<Task> tsk = loadData();
        for (Task tsks : tsk) {
            tsks.show();
            System.out.println();
        }
        return " ";
    }


    // File Loader with exception Handling
    public void loadFile() {
        File f = new File("Tasks.json");
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create Tasks");
            }
        }
    }

    // Data Organiser Function after reading file
    public List<Task> loadData() {
        List<Task> arr = new ArrayList<>();
        String[] cleaned = cleaning();
        Task obj = new Task();
        for (int i = 0; i < cleaned.length; i++) {
            if(i % 5 == 0) {
                obj = new Task();
            }
            String temp = cleaned[i];
            String[] tasks = temp.split(":");
            int t = i;
            switch (t % 5) {
                case 0 -> obj.id = Integer.parseInt(tasks[1]);
                case 1 -> obj.desc = tasks[1];
                case 2 -> obj.progress = tasks[1];
                case 3 -> {
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 1; j < tasks.length; j++) {
                        tmp.append(tasks[j]);
                        tmp.append(":");
                    }
                    tmp.deleteCharAt(tmp.length()-1);
                    obj.timeCreated = tmp.toString();
                }
                case 4 -> {
                    StringBuilder tmp1 = new StringBuilder();
                    for (int j = 1; j < tasks.length; j++) {
                        tmp1.append(tasks[j]);
                        tmp1.append(":");
                    }
                    tmp1.deleteCharAt(tmp1.length()-1);
                    obj.timeUpdated = tmp1.toString();
                    arr.add(obj);
                }
            }            
        }
        return arr;
    }

    // Cleaner Function of data
    public String[] cleaning() {

        String[] raw = readFile();
        
        StringBuilder raw1 = new StringBuilder();
        for (String raw2 : raw) {
            if (!((raw2.equals("[")) || (raw2.equals("{")) || (raw2.equals("}")) || (raw2.equals("]")) || (raw2.equals("\"")))) {
                raw1.append(raw2);
            }
        }
        String[] arr = raw1.toString().split(",");
        return arr;
    }

    // File Reader Function
    public String[] readFile() {
        try {
            StringBuilder str = new StringBuilder();
            File f = new File("Tasks.json");
            try (Scanner scan = new Scanner(f)) {
                while(scan.hasNextLine()) {
                    str.append(scan.nextLine());
                }
            }
            String[] seprated = str.toString().split("");
            return seprated;
        } catch (FileNotFoundException e) {
            System.out.println("File is not Readable");
            return null;
        }
    }
}