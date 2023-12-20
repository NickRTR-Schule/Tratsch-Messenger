package gemeinsam;

@SuppressWarnings("serial")
public class ClientBotschaftLogout extends Botschaft
{
	private String benutzername;
	
	public ClientBotschaftLogout(String pBenutzername)
	{
		benutzername = pBenutzername;
	}
	
	public String liesBenutzername()
	{
		return benutzername;
	}
}
