package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CatController 
{
	private static final String BASE_URL = "/api/cards";
    private CatCardDAO catCardDao;
    private CatFactService catFactService;	
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) 
    {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    //The cards
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET)
    public List<CatCard> list()
    {
    	List<CatCard> catCards = catCardDao.list();
    	
    	return catCards;
    }

    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
	public CatCard getCardById(@PathVariable long id)
	{
		return catCardDao.get(id);
	}
    
    @RequestMapping(value = BASE_URL + "/random", method = RequestMethod.GET)
    public CatCard getRandomCard()
    {
    	CatCard catCard = new CatCard();
    	CatPic catPic = catPicService.getPic();
    	CatFact catFact = catFactService.getFact();
    	
    	catCard.setImgUrl(catPic.getFile());
    	catCard.setCatFact(catFact.getText());
    	
    	return catCard;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping(value = BASE_URL, method = RequestMethod.POST)
	public void saveCard(@Valid @RequestBody CatCard catCard)
	{
		catCardDao.save(catCard);
	}

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
	public void updateCard(@RequestBody CatCard catCard, @Valid @PathVariable long id)
	{
		catCardDao.update(id, catCard);
	}

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
	public void deleteCard(@Valid @PathVariable long id)
	{
		catCardDao.delete(id);
	}
}
