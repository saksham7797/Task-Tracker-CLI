

public class Task {
    int id;
    String desc;
    String progress;
    String timeCreated;
    String timeUpdated;    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public void show() {
        System.out.println("ID: " + id); 
        System.out.println("Description: " + desc);
        System.out.println("Progress: " + progress);  
        System.out.println("Time Created: " + timeCreated);
        System.out.println("Time Updated: " + timeUpdated);
    }
}
