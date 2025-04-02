package enums;

public enum Menus {

    CADASTRAR_USUARIO(1, "Cadastrar Usuario"),
    CADASTRAR_LIVRO(2, "Cadastrar Usuario");

    private final int option;
    private final String description;

    Menus(int option, String description){
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static Menus selectOption(int opt){
        for(Menus option : Menus.values()){
            if(option.getOption() == opt){
                return option;
            }
        }
        return null;
    }

}
