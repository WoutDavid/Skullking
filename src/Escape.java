public class Escape extends PersonaCard{
    private String name;
    private String[] killedBy;
    private String[] trumps;

    public Escape(){
        this.name="Escape";
        this.killedBy=new String[]{"Skullking", "Pirate", "Mermaid"};
        this.trumps=new String[]{};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getKilledBy() {
        return killedBy;
    }

    public void setKilledBy(String[] killedBy) {
        this.killedBy = killedBy;
    }

    public String[] getTrumps() {
        return trumps;
    }

    public void setTrumps(String[] trumps) {
        this.trumps = trumps;
    }
    
    
}
