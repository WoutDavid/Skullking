public class SkullKing extends PersonaCard {
    private String name;
    private String[] trumps;
    private String[] killedBy;

    public SkullKing(){
        this.name = "Skullking";
        this.trumps=new String[]{"Pirate"};
        this.killedBy=new String[]{"Mermaid"};
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
