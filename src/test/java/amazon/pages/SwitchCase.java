package amazon.pages;

public class SwitchCase {
    public static String IDforField(String fieldID) {
        switch (fieldID) {
            case "name":
                fieldID = "ap_customer_name";
                break;
            case "email":
                fieldID = "ap_email";
                break;
            case "password":
                fieldID = "ap_password";
                break;
            case "re enter password":
                fieldID = "ap_password_check";
                break;
        }
        return fieldID;
    }
}
