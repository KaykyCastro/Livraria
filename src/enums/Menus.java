package enums;

public enum Menus {
    MENU_PRINCIPAL(0, "--------MENU--------"),
    CADASTRAR_USUARIO(1, "Cadastrar Usuario"),
    CADASTRAR_LIVRO(2, "Cadastrar Livro");

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
                switch (opt){
                    case 0:
                        System.out.println(MENU_PRINCIPAL.description);
                        System.out.println(CADASTRAR_USUARIO.getOption() + " - " + CADASTRAR_USUARIO.description);
        }
        return null;
    }

}
