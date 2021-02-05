class contact {
    private Integer cid;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private String inmatric;
    private String dataitp;
    private int uid;

    public contact() {}
    
    public contact(Integer cid, String fname, String lname, String phone, String email, String inmatric, String dataitp, int uid) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.inmatric = inmatric;
        this.dataitp = dataitp;
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInmatric() {
        return inmatric;
    }

    public void setInmatric(String inmatric) {
        this.inmatric = inmatric;
    }

    public String getDataitp() {
        return dataitp;
    }

    public void setDataitp(String dataitp) {
        this.dataitp = dataitp;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

   
    
    
    
    
}
