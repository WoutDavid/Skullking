public abstract class PersonaCard extends Card {
    private String name;
    private String[] trumps;
    private String[] killedBy;

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

    @Override
    public String toString() {
        return "PersonaCard [name=" + name + "]";
    }
    
    

}
