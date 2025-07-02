interface MbValidator {
    boolean isValid(String mbNo);
}

class MbNoValidator implements MbValidator {
    @Override
    public boolean isValid(String mbNo) {
        return mbNo.matches("^[6-9]\\d{9}$");
    }
}

public class MobileNumberValidator {
    public static void main(String[] args) {
        MbValidator val = new MbNoValidator();

        String mbNo = "8806843084";
        if(val.isValid(mbNo)) {
            System.out.println("Valid mobile number!");
        }
        else {
            System.out.println("Invalid mobile number.");
        }
    }
}