package ru.bellintegrator.singglerr.practice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.singglerr.practice.dao.country.CountryDao;
import ru.bellintegrator.singglerr.practice.dao.doctype.DocTypeDao;
import ru.bellintegrator.singglerr.practice.dao.office.OfficeDao;
import ru.bellintegrator.singglerr.practice.dao.user.UserDao;
import ru.bellintegrator.singglerr.practice.model.*;
import ru.bellintegrator.singglerr.practice.model.mapper.MapperFacade;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.user.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// TODO UserServiceImpl
/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final OfficeDao officeDao;
    private final UserDao userDao;
    private final DocTypeDao docTypeDao;
    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(OfficeDao officeDao, UserDao userDao, DocTypeDao docTypeDao, CountryDao countryDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.userDao = userDao;
        this.docTypeDao = docTypeDao;
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SimpleUserView> usersByFilter(@Valid UserFilterView userFilter) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserView userById(@NotNull Long id) {
        User user = userDao.loadById(id);
        UserView userView = new UserView(
                id,
                user.getFirstName(),
                user.getSecondName(),
                user.getMiddleName(),
                user.getPosition().getName(),
                user.getPhone(),
                user.getDocument().getDocType().getName(),
                user.getDocument().getNumber(),
                user.getDocument().getDate(),
                user.getCountry().getCode(),
                user.getDocument().isIdentified()
                );
        return userView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView add(@Valid SaveUserView userView) {
        Office office = officeDao.loadById(userView.getOfficeId());
        Document document = null;
        Country country = null;
        Position position = new Position(userView.getPosition());
        if ((userView.getDocCode() != null || userView.getDocName() != null) &&
                userView.getDocDate() != null &&
                userView.getDocNumber() != null){
            DocType docType;
            if (userView.getDocCode() != null){
                docType = docTypeDao.loadByCode(userView.getDocCode());
            }
            else {
                docType = docTypeDao.loadByName(userView.getDocName());
            }
            document = new Document(
                    userView.getDocNumber(),
                    userView.getDocDate(),
                    userView.getIdentified(),
                    docType
            );
        }
        if (userView.getCitizenshipCode() != null){
            country = countryDao.loadByCode(userView.getCitizenshipCode());
        }
        User user = new User(
                userView.getFirstName(),
                userView.getSecondName(),
                userView.getMiddleName(),
                userView.getPhone(),
                document,
                office,
                country,
                position
        );
        userDao.save(user);
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(@Valid UpdateUserView userView) {
        return null;
    }
}
