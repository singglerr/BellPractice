package ru.bellintegrator.singglerr.practice.service.user;

import org.springframework.stereotype.Service;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.user.*;

import javax.validation.Valid;
import java.util.List;

// TODO UserServiceImpl
/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

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
    public UserView userById(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView add(@Valid SaveUserView userView) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(@Valid UpdateUserView userView) {
        return null;
    }
}
