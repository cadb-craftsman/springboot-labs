package com.coursera.impatient;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coursera.impatient.dao.AppointmentDao;
import com.coursera.impatient.dao.CheckInDao;
import com.coursera.impatient.dao.TreatementDao;
import com.coursera.impatient.dao.UserDao;
import com.coursera.impatient.dao.UserLoginDao;
import com.coursera.impatient.dao.WaitingDao;
import com.coursera.impatient.model.CheckIn;
import com.coursera.impatient.model.Treatment;
import com.coursera.impatient.model.TreatmentList;
import com.coursera.impatient.model.User;
import com.coursera.impatient.model.UserDate;
import com.coursera.impatient.model.UserLogin;
import com.coursera.impatient.model.Waiting;
import com.coursera.impatient.model.WaitingList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ImpatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImpatientController.class);
	
	 @Autowired
	 private UserDao userDao;
	 @Autowired
	 private UserLoginDao userLoginDao;
	 @Autowired
	 private CheckInDao checkInDao;
	 @Autowired
	 private AppointmentDao appoinmentDao;
	 @Autowired
	 private TreatementDao treatmentDao;
	 @Autowired
	 private WaitingDao waitingDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	//@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	//public @ResponseBody UserLogin getUserLogin(@RequestParam(value="username", required=true) String  userName){
	public @ResponseBody UserLogin getUserLogin(@RequestBody UserLogin  userLogin){

		UserLogin uLogin = userLoginDao.getUserLoginById(userLogin.getUsername(), userLogin.getPassword());
		return uLogin;
		
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	//@RequestMapping(value = "/user", method = RequestMethod.GET)
	//public @ResponseBody User getUser(@RequestParam(value="username", required=true) String  userName){
	public @ResponseBody User getUser(@RequestBody UserLogin userLogin){

		User user = userDao.getUserById(userLogin.getUserId());
		return user;
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.POST)
	//@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	//public @ResponseBody User getUserDoctor(@RequestParam(value="userId", required=true) String userId){
	public @ResponseBody User getUserDoctor(@RequestBody UserLogin userLogin){
		
		User user = userDao.getUserById(userLogin.getUserId());
		return user;
	}

	@RequestMapping(value = "/checkIn", method = RequestMethod.POST)
	//@RequestMapping(value = "/checkIn", method = RequestMethod.GET)
	//public @ResponseBody CheckIn getUserCheckIn(@RequestParam(value="userId", required=true) String userId){
	public @ResponseBody CheckIn getUserCheckIn(@RequestBody UserLogin userLogin){
		
		CheckIn uCheckIn = checkInDao.getCheckInById(userLogin.getUserId());
		//CheckIn uCheckIn = checkInDao.getCheckInById(userId);
		return uCheckIn;
	}

	@RequestMapping(value = "/date", method = RequestMethod.POST)
	//@RequestMapping(value = "/date", method = RequestMethod.GET)
	//public @ResponseBody UserDate getUserDate(@RequestParam(value="userId", required=true) String userId){
	public @ResponseBody UserDate getUserDate(@RequestBody UserLogin userLogin){

		UserDate uDate = appoinmentDao.getAppointmentById(userLogin.getUserId());
		//UserDate uDate = appoinmentDao.getAppointmentById(userId);
		return uDate;
	}

	@RequestMapping(value = "/treatment", method = RequestMethod.POST)
	//@RequestMapping(value = "/treatment", method = RequestMethod.GET)
	//public @ResponseBody TreatmentList getTreatment(@RequestParam(value="userId", required=true) String userId){
	public @ResponseBody TreatmentList getTreatment(@RequestBody UserLogin userLogin){		
		
		TreatmentList tList = new TreatmentList();
		List<Treatment> list = treatmentDao.getTreatmentById(userLogin.getUserId());
		tList.setTreatemntList(list);
		
		return tList;
	}
	
	@RequestMapping(value = "/waitingList", method = RequestMethod.POST)
	//@RequestMapping(value = "/waitingList", method = RequestMethod.GET)
	//public @ResponseBody WaitingList getWaitingList(@RequestParam(value="userId", required=true) String userId){
	public @ResponseBody WaitingList getWaitingList(@RequestBody UserLogin userLogin){	
		
		CheckIn uCheckIn = checkInDao.getCheckInById(userLogin.getUserId());
		
		WaitingList wList = new WaitingList();
		List<Waiting> list = waitingDao.getWaitingById(uCheckIn.getDate());		
		wList.setDate(uCheckIn.getDate());
		wList.setWaitingList(list);
		return wList;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody User updateUser(@RequestBody User user){
		
		userDao.updateUser(user);
		User uData = userDao.getUserById(user.getUserId());
		return uData;
	}
	
	@RequestMapping(value = "/updateWaitingList", method = RequestMethod.POST)
	public @ResponseBody WaitingList updateWaitingList(@RequestBody Waiting waiting){
		
		waitingDao.updateWaiting(waiting);
		List<Waiting> waitingList = waitingDao.getWaitingById(waiting.getDate());
		WaitingList wList = new WaitingList(waiting.getDate(), waitingList);
		return wList;
	}

	@RequestMapping(value = "/updateCheckIn", method = RequestMethod.POST)
	//@RequestMapping(value = "/updateCheckIn", method = RequestMethod.GET)
	//public @ResponseBody CheckIn getWaitingList(){
	public @ResponseBody CheckIn updateCheckIn(@RequestBody CheckIn checkIn){
		
		checkInDao.updateCheckIn(checkIn);
		CheckIn uCheckIn = checkInDao.getCheckInById(checkIn.getUserId());
		return uCheckIn;		
	}
	

}
