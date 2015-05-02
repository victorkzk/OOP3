package furniture;

public class Table extends Furniture {

    public enum Type {
        BEDSIDE, COFFEE, GATELEG, REFECTORY, DRAFTING, DINNING_ROOM, WORKBENCH
    }

    private Type type;

    public Table(int length, int width, int height, Type type) {
        super(length, width, height);
        this.type = type;
    }

    @Override
    public String[] getTypesList() {
        Type[] types = Type.values();
        String[] strTypes = new String[types.length];
        for (int i = 0; i < types.length; i++)
            strTypes[i] = types[i].name();
        return strTypes;
    }
}
