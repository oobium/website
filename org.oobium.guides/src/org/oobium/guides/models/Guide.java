package org.oobium.guides.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.oobium.app.server.view.View;
import org.oobium.utils.StringUtils;
import org.oobium.guides.models.guides.AllAboutEspFiles;
import org.oobium.guides.models.guides.GettingStarted;
import org.oobium.guides.models.guides.LayoutsAndRenderingInOobium;
import org.oobium.guides.models.guides.OobiumDatabaseMigrations;
import org.oobium.guides.models.guides.OobiumQueryInterface;
import org.oobium.guides.models.guides.OobiumRelations;
import org.oobium.guides.models.guides.OobiumRoutingFromTheOutsideIn;

public class Guide {

	public static final Map<String, List<String>> programs;
	public static final Map<String, Guide> guides;
	
	static {
		programs = new LinkedHashMap<String, List<String>>();
		guides = new LinkedHashMap<String, Guide>();

		add("Start Here", new GettingStarted());
		add("Models", new OobiumDatabaseMigrations());
		add("Models", new OobiumQueryInterface());
		add("Models", new OobiumRelations());
		add("Views", new LayoutsAndRenderingInOobium());
		add("Views", new AllAboutEspFiles());
		add("Controllers", new OobiumRoutingFromTheOutsideIn());
	}
	
	private static void add(String program, Guide guide) {
		String path = guide.getPath();
		List<String> list = programs.get(program);
		if(list == null) {
			list = new ArrayList<String>();
			programs.put(program, list);
		}
		list.add(path);
		guides.put(path, guide);
	}
	
	
	public View intro;
	public String summary;
	public Chapter[] chapters;
	public Ticket ticket;

	public Guide(View intro) {
		this.intro = intro;
	}
	
	public String getTitle() {
		return intro.getTitle();
	}
	
	public String getPath() {
		return StringUtils.underscored(intro.getTitle());
	}
	
}