package pl.edu.pja.stable.managers;

import pl.edu.pja.stable.dao.*;
import pl.edu.pja.stable.daoimpl.hibernate.*;

/**
 * Created by Magdalena on 2017-06-18.
 */
public class SessionManager {

    private static IClientDao clientDao = (IClientDao) new HbnClientDao();
    private static ICompetitionDao competitionDao = (ICompetitionDao) new HbnCompetitionDao();
    private static IContestantDao contestantDao = (IContestantDao) new HbnContestantDao();
    private static IEmployeeDao employeeDao = (IEmployeeDao) new HbnEmployeeDao();
    private static IGroomDao groomDao = (IGroomDao) new HbnGroomDao();
    private static IHorseDao horseDao = (IHorseDao) new HbnHorseDao();
    private static IInstructorDao instructorDao = (IInstructorDao) new HbnInstructorDao();
    private static IOwnerDao ownerDao = (IOwnerDao) new HbnOwnerDao();
    private static IRidingSchoolDao ridingSchoolDao = (IRidingSchoolDao) new HbnRidingSchoolDao();
    private static IStableDao stableDao = (IStableDao) new HbnStableDao();
    private static IStallDao stallDao = (IStallDao) new HbnStallDao();


    public static IClientDao getClientDao() {
        return clientDao;
    }

    public static ICompetitionDao getCompetitionDao() {
        return competitionDao;
    }

    public static IContestantDao getContestantDao() {
        return contestantDao;
    }

    public static IEmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public static IGroomDao getGroomDao() {
        return groomDao;
    }

    public static IHorseDao getHorseDao() {
        return horseDao;
    }

    public static IInstructorDao getInstructorDao() {
        return instructorDao;
    }

    public static IOwnerDao getOwnerDao() {
        return ownerDao;
    }

    public static IRidingSchoolDao getRidingSchoolDao() {
        return ridingSchoolDao;
    }

    public static IStableDao getStableDao() {
        return stableDao;
    }

    public static IStallDao getStallDao() {
        return stallDao;
    }
}
