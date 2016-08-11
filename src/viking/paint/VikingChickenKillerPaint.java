package viking.paint;

import viking.framework.paint.VikingPaint;
import viking.framework.paint.plugin.VikingPaintPlugin;
import viking.framework.paint.plugin.impl.basic_paints.VikingDevPlugin;
import viking.framework.paint.plugin.impl.image.ImagePlugin;
import viking.framework.paint.plugin.impl.image.interactable.NameCover;
import viking.script.VikingChickenKiller;

public class VikingChickenKillerPaint extends VikingPaint<VikingChickenKiller>
{
	private static final String LOGO_URL = "/script/paint/chickenkiller/logo.png";
	private static final int LOGO_X = 264; 
	private static final int LOGO_Y = 268;
	
	public VikingChickenKillerPaint(VikingChickenKiller script)
	{
		super(script);
	}

	@Override
	protected VikingPaintPlugin[] generatePlugins(VikingChickenKiller script)
	{
		return new VikingPaintPlugin[]
		{
				new VikingDevPlugin(script, this),
				new ImagePlugin(script, this, script.getVikingWebsite() + LOGO_URL, LOGO_X, LOGO_Y),
				new NameCover(script, this),
				new VCKPaintContainer(script, this)
		};
	}

}
