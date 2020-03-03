public class Client {

    private String fullName;
    private String name;

    public Client(String fullname) {
        this.fullName = fullname;
        int i = fullname.indexOf(" ");
        int j = fullname.indexOf(" ",i+1);
        this.name = fullname.substring(i, j != -1 ? j : fullname.length());
    }

    @Override
    public String toString() {
        return "Имя =" + fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName(){
        return name;
    }

}
