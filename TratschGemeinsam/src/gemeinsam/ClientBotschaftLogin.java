package gemeinsam;

@SuppressWarnings("serial")
public class ClientBotschaftLogin extends Botschaft
{
	private String benutzername;
	private String password;
	
	public ClientBotschaftLogin(String pBenutzername, String pPassword)
	{
		benutzername = pBenutzername;
		password = pPassword;
	}
	
	public String liesBenutzername()
	{
		return benutzername;
	}
	
	public String liesPassword()
	{
		return password;
	}
}
