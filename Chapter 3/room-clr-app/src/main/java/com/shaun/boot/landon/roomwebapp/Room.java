package com.shaun.boot.landon.roomwebapp;

public class Room {
    private long id;
    private String name;
    private String number;
    private String info;

    public Room() {
        super();
    }

    public Room(long id, String name, String number, String info) {
        super();
        this.id = id;
        this.name = name;
        this.number = number;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", number=");
		builder.append(number);
		builder.append(", info=");
		builder.append(info);
		builder.append("]");
		return builder.toString();
	}
    
    
}
