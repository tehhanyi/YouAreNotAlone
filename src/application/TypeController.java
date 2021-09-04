package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TypeController{
	@FXML
	private VBox bg;
	@FXML
	private Text type;
	@FXML
	private ImageView type_img;
	@FXML
	private Text desc1;
	@FXML
	private Text desc2;
    @FXML
    private Text strengths;
    @FXML
    private Text weaknesses;
    @FXML
    private WebView web;
    @FXML
    private ScrollPane scroll;

    @FXML
    void Home(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz.fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage Home = new Stage();
	        Home.getIcons().add(new Image(logo));
			Home.setScene(scene);
			Home.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void otherTypes(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Types.fxml"));
			Scene typescene = new Scene(root,1366,768);
			Stage Type = new Stage();
			Type.getIcons().add(new Image(logo));
			Type.setScene(typescene);
			Type.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
	public void fetchMBTI(String mbti) {
        Image image = new Image(getClass().getResourceAsStream("/img/"+mbti+".png"));
	    type_img.setImage(image);
	    
	    if (mbti.equals("INTJ")||mbti.equals("INTP")||mbti.equals("ENTJ")||mbti.equals("ENTP")){
	    	bg.setStyle("-fx-background-color: #e8d8e0");
	    	if (mbti.equals("INTJ"))setTypeScene(mbti," - Architect",INTJ[3],INTJ[4],INTJ[1],INTJ[2]);
	    	if (mbti.equals("INTP"))setTypeScene(mbti," - Logician",INTP[3],INTP[4],INTP[1],INTP[2]);
	    	if (mbti.equals("ENTJ"))setTypeScene(mbti," - Commander",ENTJ[3],ENTJ[4],ENTJ[1],ENTJ[2]);
	    	if (mbti.equals("ENTP"))setTypeScene(mbti," - Debater",ENTP[3],ENTP[4],ENTP[1],ENTP[2]);
	    }
	    else if (mbti.equals("INFJ")||mbti.equals("INFP")||mbti.equals("ENFJ")||mbti.equals("ENFP")){
	    	bg.setStyle("-fx-background-color: #dbeee6");
	    	 if (mbti.equals("INFJ"))setTypeScene(mbti," - Advocate",INFJ[3],INFJ[4],INFJ[1],INFJ[2]);
	    	 if (mbti.equals("INFP"))setTypeScene(mbti," - Mediator",INFP[3],INFP[4],INFP[1],INFP[2]);
	    	 if (mbti.equals("ENFJ"))setTypeScene(mbti," - Protagonist",ENFJ[3],ENFJ[4],ENFJ[1],ENFJ[2]);
	    	 if (mbti.equals("ENFP"))setTypeScene(mbti," - Campaigner",ENFP[3],ENFP[4],ENFP[1],ENFP[2]);
	    }
	    else if (mbti.equals("ISTJ")||mbti.equals("ISFJ")||mbti.equals("ESTJ")||mbti.equals("ESFJ")){
	    	bg.setStyle("-fx-background-color: #cde6e7");
	    	if (mbti.equals("ISTJ"))setTypeScene(mbti," - Logistician",ISTJ[3],ISTJ[4],ISTJ[1],ISTJ[2]);
	    	if (mbti.equals("ISFJ"))setTypeScene(mbti," - Defender",ISFJ[3],ISFJ[4],ISFJ[1],ISFJ[2]);
	    	if (mbti.equals("ESTJ"))setTypeScene(mbti," - Executive",ESTJ[3],ESTJ[4],ESTJ[1],ESTJ[2]);
	    	if (mbti.equals("ESFJ"))setTypeScene(mbti," - Consul",ESFJ[3],ESFJ[4],ESFJ[1],ESFJ[2]);
	    }
	    else if (mbti.equals("ISTP")||mbti.equals("ISFP")||mbti.equals("ESTP")||mbti.equals("ESFP")){
	    	bg.setStyle("-fx-background-color: #f7e7cb");
	    	if (mbti.equals("ISTP"))setTypeScene(mbti," - Virtuoso",ISTP[3],ISTP[4],ISTP[1],ISTP[2]);
	    	if (mbti.equals("ISFP"))setTypeScene(mbti," - Adventurer",ISFP[3],ISFP[4],ISFP[1],ISFP[2]);
	    	if (mbti.equals("ESTP"))setTypeScene(mbti," - Entrepreneur",ESTP[3],ESTP[4],ESTP[1],ESTP[2]);
	    	if (mbti.equals("ESFP"))setTypeScene(mbti," - Entertainer",ESFP[3],ESFP[4],ESFP[1],ESFP[2]);
	    }
    }
	private void setType(String mbti){
		Image image = new Image(getClass().getResourceAsStream("/img/"+mbti+".png"));
	    type_img.setImage(image);
  		desc1.setText(mbti);
	    if (mbti.equals("INTJ"))desc2.setText(INTJ[0]);
   	 	if (mbti.equals("INTP"))desc2.setText(INTP[0]);
   	 	if (mbti.equals("ENTJ"))desc2.setText(ENTJ[0]);
   	 	if (mbti.equals("ENTP"))desc2.setText(ENTP[0]);
   	 	if (mbti.equals("INFJ"))desc2.setText(INFJ[0]);
   	 	if (mbti.equals("INFP"))desc2.setText(INFP[0]);
   	 	if (mbti.equals("ENFJ"))desc2.setText(ENFJ[0]);
   	 	if (mbti.equals("ENFP"))desc2.setText(ENFP[0]);
   	 	if (mbti.equals("ISTJ"))desc2.setText(ISTJ[0]);
 		if (mbti.equals("ISFJ"))desc2.setText(ISFJ[0]);
 		if (mbti.equals("ESTJ"))desc2.setText(ESTJ[0]);
 		if (mbti.equals("ESFJ"))desc2.setText(ESFJ[0]);
 		if (mbti.equals("ISTP"))desc2.setText(ISTP[0]);
 		if (mbti.equals("ISFP"))desc2.setText(ISFP[0]);
    	if (mbti.equals("ESTP"))desc2.setText(ESTP[0]);
    	if (mbti.equals("ESFP"))desc2.setText(ESFP[0]);
	}
	
	private void setTypeScene(String mbti,String string, String one, String two, String strength,String weak){
		type.setText(mbti + string);
		desc1.setText(one);
		desc2.setText(two);
		strengths.setText(strength);
		weaknesses.setText(weak);
		WebEngine webEngine = web.getEngine();
		webEngine.load("https://www.16personalities.com/"+mbti.toLowerCase()+"-personality");
    	scroll.setVvalue(1);
	}
	
	private void goToType(String type){
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("Result.fxml"));
	        BorderPane root =loader.load();
	        TypeController controller = loader.getController();
	        controller.fetchMBTI(type);
	        Scene scene = new Scene(root,1366,768);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        Stage Result = new Stage();
	        Result.setScene(scene);
	        Result.getIcons().add(new Image(logo));
	        Result.show();
	        Stage quiz = (Stage)ok.getScene().getWindow();
	        quiz.close();
	        }
	 catch(Exception e) {e.printStackTrace();}
	}
	
	@FXML
    private BorderPane ok;
	@FXML
	void ENFPhover(MouseEvent event) {setType("ENFP");}
	@FXML
    void ENFP(MouseEvent event) {goToType("ENFP");}
	@FXML
	void ENFJhover(MouseEvent event) {setType("ENFJ");}
	@FXML
    void ENFJ(MouseEvent event) {goToType("ENFJ");}
	@FXML
	void ENTJhover(MouseEvent event) {setType("ENTJ");}
    @FXML
    void ENTJ(MouseEvent event) {goToType("ENTJ");}
    @FXML
	void ENTPhover(MouseEvent event) {setType("ENTP");}
    @FXML
    void ENTP(MouseEvent event) {goToType("ENTP");}
    @FXML
	void ESFJhover(MouseEvent event) {setType("ESFJ");}
    @FXML
    void ESFJ(MouseEvent event) {goToType("ESFJ");}
    @FXML
	void ESFPhover(MouseEvent event) {setType("ESFP");}
    @FXML
    void ESFP(MouseEvent event) {goToType("ESFP");}
    @FXML
	void ESTJhover(MouseEvent event) {setType("ESTJ");}
    @FXML
    void ESTJ(MouseEvent event) {goToType("ESTJ");}
    @FXML
	void ESTPhover(MouseEvent event) {setType("ESTP");}
    @FXML
    void ESTP(MouseEvent event) {goToType("ESTP");}
    @FXML
	void INFJhover(MouseEvent event) {setType("INFJ");}
    @FXML
    void INFJ(MouseEvent event) {goToType("INFJ");}
    @FXML
	void INFPhover(MouseEvent event) {setType("INFP");}
    @FXML
    void INFP(MouseEvent event) {goToType("INFP");}
    @FXML
	void INTJhover(MouseEvent event) {setType("INTJ");}
    @FXML
    void INTJ(MouseEvent event) {goToType("INTJ");}
    @FXML
	void INTPhover(MouseEvent event) {setType("INTP");}
    @FXML
    void INTP(MouseEvent event) {goToType("INTP");}
    @FXML
	void ISFJhover(MouseEvent event) {setType("ISFJ");}
    @FXML
    void ISFJ(MouseEvent event) {goToType("ISFJ");}
    @FXML
	void ISFPhover(MouseEvent event) {setType("ISFP");}
    @FXML
    void ISFP(MouseEvent event) {goToType("ISFP");}
    @FXML
	void ISTJhover(MouseEvent event) {setType("ISTJ");}
    @FXML
    void ISTJ(MouseEvent event) {goToType("ISTJ");}
    @FXML
	void ISTPhover(MouseEvent event) {setType("ISTP");}
    @FXML
    void ISTP(MouseEvent event)  {goToType("ISTP");}
    String logo = "/img/WNRS.png";
    
    String[] INTJ = {
    		"Imaginative and Strategic Thinkers, with a Plan for Everything",
    		"Rational" + ", Informed" + ", Independent" + ", Determined" + ", Curious" + ", Versatile",
    		"Arrogant" + ", Dismissive of Emotions" + ", Overly Critical" + ", Combative" + ", Romantically Clueless",
    		"An Architect (INTJ) is a person with the Introverted, Intuitive, Thinking, and Judging personality traits. These thoughtful tacticians love perfecting the details of life, applying creativity and rationality to everything they do. Their inner world is often a private, complex one.",
    		"It can be lonely at the top. As one of the rarest personality types – and one of the most capable – Architects (INTJs) know this all too well. Rational and quick-witted, Architects may struggle to find people who can keep up with their nonstop analysis of everything around them."
    	};
	String[] INTP = {
			"Innovative Inventors with an Unquenchable Thirst for Knowledge",
			"Analytical" + ", Original" + ", Open-Minded" + ", Curious" + ", Objective",
			"Disconnected" + ", Insensitive" + ", Dissatisfied" + ", Impatient" + ", Perfectionistic",
			"A Logician (INTP) is someone with the Introverted, Intuitive, Thinking, and Prospecting personality traits. These flexible thinkers enjoy taking an unconventional approach to many aspects of life. They often seek out unlikely paths, mixing willingness to experiment with personal creativity",
			"Logicians pride themselves on their unique perspectives and vigorous intellect. They can’t help but puzzle over the mysteries of the universe – which may explain why some of the most influential philosophers and scientists of all time have been Logicians. This personality type is fairly rare, but with their creativity and inventiveness, Logicians aren’t afraid to stand out from the crowd."
			};
	
	String[] ENTJ = {
			"Bold, Imaginative and Strong-willed Leaders, Always Finding a Way - or Making one",
			"Efficient" + ", Energetic" + ", Self-Confident" + ", Strong-Willed" + ", Strategic Thinkers" +", Charismatic and Inspiring",
			"Stubborn and Dominant" + ", Intolerant" + ", Impatient" + ", Poor Handling of Emotions" + ", Cold and Ruthless",
			"A Commander (ENTJ) is someone with the Extraverted, Intuitive, Thinking, and Judging personality traits. They are decisive people who love momentum and accomplishment. They gather information to construct their creative visions but rarely hesitate for long before acting on them.?",
			"Commanders are natural-born leaders. People with this personality type embody the gifts of charisma and confidence, and project authority in a way that draws crowds together behind a common goal. However, Commanders are also characterized by an often ruthless level of rationality, using their drive, determination and sharp minds to achieve whatever end they’ve set for themselves. Perhaps it is best that they make up only three percent of the population, lest they overwhelm the more timid and sensitive personality types that make up much of the rest of the world – but we have Commanders to thank for many of the businesses and institutions we take for granted every day."
	};
	String[] ENTP = {
			"Smart and Curious Thinkers who cannot Resist an Intellectual Challenge",
			"Knowledgeable" + ", Quick Thinkers" + ", Original" + ", Excellent Brainstormers" + ", Charismatic" +", Energetic",
			"Very Argumentative" + ", Insensitive" + ", Intolerant" + ", Can Find It Difficult to Focus" + ", Dislike Practical Matters",
			"A Debater (ENTP) is a person with the Extraverted, Intuitive, Thinking, and Prospecting personality traits. They tend to be bold and creative, deconstructing and rebuilding ideas with great mental agility. They pursue their goals vigorously despite any resistance they might encounter.",
			"No one loves the process of mental sparring more than the Debater personality type, as it gives them a chance to exercise their effortlessly quick wit, broad accumulated knowledge base, and capacity for connecting disparate ideas to prove their points. Debaters are the ultimate devil’s advocate, thriving on the process of shredding arguments and beliefs and letting the ribbons drift in the wind for all to see. They don’t always do this because they are trying to achieve some deeper purpose or strategic goal, though. Sometimes it’s for the simple reason that it’s fun."
	};
	String[] INFJ = {
			"Quiet and Mystical, yet very Inspiring and Tireless Idealists",
			"Creative " + ", Insightful " + ", Principled " + ", Passionate " + ", Altruistic ",
			"Sensitive to Criticism, Reluctant to Open Up, Perfectionistic, Avoiding the Ordinary, Prone to Burnout",
			"An Advocate (INFJ) is someone with the Introverted, Intuitive, Feeling, and Judging personality traits. They tend to approach life with deep thoughtfulness and imagination. Their inner vision, personal values, and a quiet, principled version of humanism guide them in all things.",
			"Advocates are the rarest personality types of all. Still, Advocates leave their mark on the world. They have a deep sense of idealism and integrity, but they aren’t idle dreamers – they take concrete steps to realize their goals and make a lasting impact."
	};
	String[] INFP = {
			"Poetic, Kind and Altruistic People, always Eager to Help a Good Cause",
			"Empathetic " + ", Generous " + ", Open-Minded " + ", Creative " + ", Passionate " + ", Idealistic",
			"Unrealistic " + ", Self-Isolating " + ", Unfocused " + ", Emotionally Vulnerable " + ", Desperate to Please " + ", Self-Critical",
			"A Mediator (INFP) is someone who possesses the Introverted, Intuitive, Feeling, and Prospecting personality traits. These rare personality types tend to be quiet, open-minded, and imaginative, and they apply a caring and creative approach to everything they do.",
			"Although they may seem quiet or unassuming, Mediators (INFPs) have vibrant, passionate inner lives. Creative and imaginative, they happily lose themselves in daydreams, inventing all sorts of stories and conversations in their minds. These personalities are known for their sensitivity – Mediators can have profound emotional responses to music, art, nature, and the people around them."
	};
	String[] ENFJ = {
			"Charismatic and Inspiring Leaders, able to Mesmerize their Listeners",
			"Receptive " + ", Reliable " + ", Passionate " + ", Altruistic " + ", Charismatic",
			"Unrealistic " + ", Overly Idealistic " + ", Condescending " + ", Intense " + ", Overly Empathetic",
			"A Protagonist (ENFJ) is a person with the Extraverted, Intuitive, Feeling, and Judging personality traits. These warm, forthright types love helping others, and they tend to have strong ideas and values. They back their perspective with the creative energy to achieve their goals.",
			"Protagonists (ENFJs) feel called to serve a greater purpose in life. Thoughtful and idealistic, these personality types strive to have a positive impact on other people and the world around them. They rarely shy away from an opportunity to do the right thing, even when doing so is far from easy."
	};
	String[] ENFP = {
			"Enthusiastic, Creative and Sociable Free Spirits, who can Always Find a Reason to Smile",
			"Curious " + ", Perceptive " + ", Enthusiastic " + ", Excellent Communicators " + ", Festive " + ", Good-Natured",
			"People-Pleasing " + ", Unfocused " + ", Disorganized " + ", Overly Accommodating " + ", Overly Optimistic " + ", Restless",
			"A Campaigner (ENFP) is someone with the Extraverted, Intuitive, Feeling, and Prospecting personality traits. These people tend to embrace big ideas and actions that reflect their sense of hope and goodwill toward others. Their vibrant energy can flow in many directions.",
			"Campaigners (ENFPs) are true free spirits – outgoing, openhearted, and open-minded. With their lively, upbeat approach to life, they stand out in any crowd. But even though they can be the life of the party, Campaigners don’t just care about having a good time. These personality types run deep – as does their longing for meaningful, emotional connections with other people."
	};
	String[] ISTJ = {
			"Practical and Fact-minded Individuals, whose Reliability cannot be Doubted",
			"Honest and Direct " + ", Strong-willed and Dutiful " + ", Very Responsible " + ", Calm and Practical " + ", Create and Enforce Order " + ", Jacks-of-all-trades",
			"Stubborn " + ", Insensitive " + ", Always by the Book " + ", Judgmental " + ", Often Unreasonably Blame Themselves",
			"A Logistician (ISTJ) is someone with the Introverted, Observant, Thinking, and Judging personality traits. These people tend to be reserved yet willful, with a rational outlook on life. They compose their actions carefully and carry them out with methodical purpose.",
			"The Logistician personality type is thought to be the most abundant, making up around 13% of the population. Their defining characteristics of integrity, practical logic and tireless dedication to duty make Logisticians a vital core to many families, as well as organizations that uphold traditions, rules and standards, such as law offices, regulatory bodies and military. People with the Logistician personality type enjoy taking responsibility for their actions, and take pride in the work they do – when working towards a goal, Logisticians hold back none of their time and energy completing each relevant task with accuracy and patience."
	};
	String[] ISFJ = {
			"Very Dedicated and Warm Protectors, always Ready to Defend their Loved Ones",
			"Supportive " + ", Reliable and Patient " + ", Imaginative and Observant " + ", Enthusiastic " + ", Loyal and Hard-Working "+", Good Practical Skills",
			"Humble and Shy " + ", Take Things Too Personally " + ", Repress Their Feelings " + ", Overload Themselves " + ", Reluctant to Change " +", Too Altruistic",
			"A Defender (ISFJ) is someone with the Introverted, Observant, Feeling, and Judging personality traits. These people tend to be warm and unassuming in their own steady way. They’re efficient and responsible, giving careful attention to practical details in their daily lives.",
			"The Defender personality type is quite unique, as many of their qualities defy the definition of their individual traits. Though sensitive, Defenders have excellent analytical abilities; though reserved, they have well-developed people skills and robust social relationships; and though they are generally a conservative type, Defenders are often receptive to change and new ideas. As with so many things, people with the Defender personality type are more than the sum of their parts, and it is the way they use these strengths that defines who they are."
	};
	String[] ESTJ = {
			"Excellent Administrators, Unsurpassed at Managing Things - or people",
			"Dedicated " + ", Strong-willed " + ", Direct and Honest " + ", Loyal, Patient and Reliable " + ", Enjoy Creating Order " + ", Excellent Organizers",
			"Inflexible and Stubborn " + ", Uncomfortable with Unconventional Situations " + ", Judgmental " + ", Too Focused on Social Status " + ", Difficult to Relax " + ", Difficulty Expressing Emotion",
			"An Executive (ESTJ) is someone with the Extraverted, Observant, Thinking, and Judging personality traits. They possess great fortitude, emphatically following their own sensible judgment. They often serve as a stabilizing force among others, able to offer solid direction amid adversity.",
			"Executives are representatives of tradition and order, utilizing their understanding of what is right, wrong and socially acceptable to bring families and communities together. Embracing the values of honesty, dedication and dignity, people with the Executive personality type are valued for their clear advice and guidance, and they happily lead the way on difficult paths. Taking pride in bringing people together, Executives often take on roles as community organizers, working hard to bring everyone together in celebration of cherished local events, or in defense of the traditional values that hold families and communities together."
	};
	String[] ESFJ = {
			"Extraordinarily Caring, Social and Popular People, always Eager to Help",
			"Strong Practical Skills " + ", Strong Sense of Duty " + ", Very Loyal " + ", Sensitive and Warm " + ", Good at Connecting with Others",
			"Worried about Their Social Status " + ", Inflexible " + ", Reluctant to Innovate or Improvise " + ", Vulnerable to Criticism " + ", Often Too Needy " + ", Too Selfless",
			"A Consul (ESFJ) is a person with the Extraverted, Observant, Feeling, and Judging personality traits. They are attentive and people-focused, and they enjoy taking part in their social community. Their achievements are guided by decisive values, and they willingly offer guidance to others.",
			"People who share the Consul personality type are, for lack of a better word, popular – which makes sense, given that it is also a very common personality type, making up twelve percent of the population. In high school, Consuls are the cheerleaders and the quarterbacks, setting the tone, taking the spotlight and leading their teams forward to victory and fame. Later in life, Consuls continue to enjoy supporting their friends and loved ones, organizing social gatherings and doing their best to make sure everyone is happy."
	};
	String[] ISTP = {
			"Bold and Practical Experimenters, Masters of All Kinds of Tools",
			"Optimistic and Energetic " + ", Creative and Practical " + ", Spontaneous and Rational " + ", Know How to Prioritize " + ", Great in a Crisis " + ", Relaxed",
			"Stubborn " + ", Insensitive" + ", Private and Reserved " + ", Easily Bored " + ", Dislike Commitment " + ", Risky Behavior",
			"A Virtuoso (ISTP) is someone with the Introverted, Observant, Thinking, and Prospecting personality traits. They tend to have an individualistic mindset, pursuing goals without needing much external connection. They engage in life with inquisitiveness and personal skill, varying their approach as needed.",
			"Virtuosos love to explore with their hands and their eyes, touching and examining the world around them with cool rationalism and spirited curiosity. People with this personality type are natural Makers, moving from project to project, building the useful and the superfluous for the fun of it, and learning from their environment as they go. Often mechanics and engineers, Virtuosos find no greater joy than in getting their hands dirty pulling things apart and putting them back together, just a little bit better than they were before."
	};
	String[] ISFP = {
			"Flexible and Charming Artists, always Ready to Explore and Experience Something New",
			"Charming " + ", Sensitive to Others " + ", Imaginative " + ", Passionate " + ", Curious " + ", Artistic",
			"Fiercely Independent " + ", Unpredictable " + ", Easily Stressed " + ", Overly Competitive " + ", Fluctuating Self-Esteem",
			"An Adventurer (ISFP) is a person with the Introverted, Observant, Feeling, and Prospecting personality traits. They tend to have open minds, approaching life, new experiences, and people with grounded warmth. Their ability to stay in the moment helps them uncover exciting potentials.",
			"Adventurer personalities are true artists, but not necessarily in the typical sense where they’re out painting happy little trees. Often enough though, they are perfectly capable of this. Rather, it’s that they use aesthetics, design and even their choices and actions to push the limits of social convention. Adventurers enjoy upsetting traditional expectations with experiments in beauty and behavior – chances are, they’ve expressed more than once the phrase “Don’t box me in!”"
	};
	String[] ESTP = {
			"Smart, Energetic and Very Perceptive People, who truly Enjoy Living on the Edge",
			"Bold " + ", Rational and Practical " + ", Original " + ", Perceptive " + ", Direct " + ", Sociable",
			"Insensitive " + ", Impatient " + ", Risk-prone " + ", Unstructured " + ", May Miss the Bigger Picture " + ", Defiant",
			"An Entrepreneur (ESTP) is someone with the Extraverted, Observant, Thinking, and Prospecting personality traits. They tend to be energetic and action-oriented, deftly navigating whatever is in front of them. They love uncovering life’s opportunities, whether socializing with others or in more personal pursuits.",
			"Entrepreneurs always have an impact on their immediate surroundings – the best way to spot them at a party is to look for the whirling eddy of people flitting about them as they move from group to group. Laughing and entertaining with a blunt and earthy humor, Entrepreneur personalities love to be the center of attention. If an audience member is asked to come on stage, Entrepreneurs volunteer – or volunteer a shy friend."
	};
	String[] ESFP = {
			"Spontaneous, Energetic and Enthusiastic People - Life is Never Boring around them",
			"Bold " + ", Original " + ", Aesthetics and Showmanship " + ", Practical " + ", Excellent People Skills " + ", Observant ",
			"Sensitive " + ", Conflict-Averse " + ", Easily Bored " + ", Poor Long-Term Planners " + ", Unfocused",
			"An Entertainer (ESFP) is a person with the Extraverted, Observant, Feeling, and Prospecting personality traits. These people love vibrant experiences, engaging in life eagerly and taking pleasure in discovering the unknown. They can be very social, often encouraging others into shared activities.",
			"If anyone is to be found spontaneously breaking into song and dance, it is the Entertainer personality type. Entertainers get caught up in the excitement of the moment, and want everyone else to feel that way, too. No other personality type is as generous with their time and energy as Entertainers when it comes to encouraging others, and no other personality type does it with such irresistible style."
	};
}