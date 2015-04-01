package es.art83.web.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BasicBean {
    private String name = "Soy Bean";

    private String[] array = {"cero", "uno", "dos"};

    private List<String> list = new ArrayList<String>();

    private Map<String, String> map = new HashMap<String, String>();

    private Entity entity = new Entity();
    
    private String selectedItemArray = "";

    public String getSelectedItemArray() {
		return selectedItemArray;
	}

	public void setSelectedItemArray(String selectedItemArray) {
		this.selectedItemArray = selectedItemArray;
	}

	public BasicBean() {
        this.list.add("cero");
        this.list.add("uno");
        this.map.put("cero", "0");
        this.map.put("uno", "1");
    }

    public int method(int v) {
        return v * 3;
    }

    public int method2() {
        return 2;
    }

    public String process() {
    	System.out.println("poipoipoi");
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getArray() {
        return array;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Entity getEntity() {
        return entity;
    }

}
