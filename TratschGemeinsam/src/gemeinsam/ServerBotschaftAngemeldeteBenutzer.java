package gemeinsam;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ServerBotschaftAngemeldeteBenutzer extends Botschaft
{
	private ArrayList<String> angemeldeteBenutzer;
	
	public ServerBotschaftAngemeldeteBenutzer(ArrayList<String> pAngemeldeteBenutzer)
	{
		angemeldeteBenutzer = pAngemeldeteBenutzer;
	}
	
	public ArrayList<String> liesAngemeldeteBenutzer()
	{
		return angemeldeteBenutzer;
	}
}
