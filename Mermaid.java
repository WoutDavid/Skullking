public class Mermaid extends PersonaCard{
    private String name;
    private String[] trumps;
    private String[] killedBy;

    public Mermaid(){
        this.name="Mermaid";
        this.trumps = new String[]{"Skullking"};
        this.killedBy=new String[]{"Pirate"};
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
