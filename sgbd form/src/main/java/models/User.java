package models;

public class User {
    private Integer id;
    private String prenom;
    private String civilite;
    private String pays;
    private String description;
    private boolean inMailingList;
    private String mdp;
    private String role;

    @Override
    public String toString() {
        String message = "Bonjour, je suis " + civilite + " " + prenom + ", j'habite en " + pays + ", je suis " + role
                + ".";
        return message;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + (inMailingList ? 1231 : 1237);
        result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
        result = prime * result + ((pays == null) ? 0 : pays.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (civilite == null) {
            if (other.civilite != null)
                return false;
        } else if (!civilite.equals(other.civilite))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (inMailingList != other.inMailingList)
            return false;
        if (mdp == null) {
            if (other.mdp != null)
                return false;
        } else if (!mdp.equals(other.mdp))
            return false;
        if (pays == null) {
            if (other.pays != null)
                return false;
        } else if (!pays.equals(other.pays))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

    public User() {
        this("Deborah", "Mlle.", "France", "Belle, sociable, intelligente, gentille, sociable et hardie", true,
                "noisette", "élêve");
    }

    public User(String prenom, String civilite, String pays, String description, boolean inMailingList, String mdp,
                String role, int id) {
        this.prenom = prenom;
        this.civilite = civilite;
        this.pays = pays;
        this.description = description;
        this.inMailingList = inMailingList;
        this.mdp = mdp;
        this.role = role;
        this.id = id;
    }

    public User(String prenom, String civilite, String pays, String description, boolean inMailingList, String mdp,
                String role) {
        this.prenom = prenom;
        this.civilite = civilite;
        this.pays = pays;
        this.description = description;
        this.inMailingList = inMailingList;
        this.mdp = mdp;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInMailingList() {
        return inMailingList;
    }

    public void setInMailingList(boolean inMailingList) {
        this.inMailingList = inMailingList;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

