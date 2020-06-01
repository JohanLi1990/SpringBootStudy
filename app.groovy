@RestController
public class HelloWorld {
	
	@RequestMapping("/")
	public String home(){
		return "Hello World";
	}
}
