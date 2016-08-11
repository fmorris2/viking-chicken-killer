package viking.paint;

import java.util.ArrayList;
import java.util.List;

import viking.framework.paint.VikingPaint;
import viking.framework.paint.container.VContainer;
import viking.framework.paint.container.component.VComponent;
import viking.framework.script.VikingScript;

public class VCKPaintContainer extends VContainer
{
	private static final String IMAGE_URL = "/script/paint/_default/main_container_bg.png";
	private static final int X = 300;
	private static final int Y = 345;
	
	public VCKPaintContainer(VikingScript script, VikingPaint<?> paint)
	{
		super(script, paint, script.getVikingWebsite() + IMAGE_URL, X, Y);
	}

	@Override
	protected List<VComponent> initComponents()
	{
		return new ArrayList<>();
	}

}
