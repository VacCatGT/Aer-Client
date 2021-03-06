package me.aerclient.visual.render;

import me.aerclient.implementation.module.base.Module;
import me.aerclient.visual.render.render2D.font.Fonts;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class LengthSorter implements Comparator<Module> {

	@Override
	public int compare(@NotNull Module o1, @NotNull Module o2) {
		return (int) (Fonts.normal.getStringWidth(o2.getName()) - Fonts.normal.getStringWidth(o1.getName()));
	}

}
