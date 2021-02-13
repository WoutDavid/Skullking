public class Pirate extends PersonaCard{
    private String name;
    private String[] trumps;
    private String[] killedBy;

    public Pirate(){
        this.name="Pirate";
        this.trumps = new String[]{"Mermaid", "Escape"};
        this.killedBy=new String[]{"Skullking"};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTrumps() {
        return trumps;
    }

    public void setTrumps(String[] trumps) {
        this.trumps = trumps;
    }

    public String[] getKilledBy() {
        return killedBy;
    }

    public void setKilledBy(String[] killedBy) {
        this.killedBy = killedBy;
    }

    
}
