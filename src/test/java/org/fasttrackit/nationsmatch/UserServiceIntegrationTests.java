package org.fasttrackit.nationsmatch;

import org.fasttrackit.nationsmatch.domain.User;
import org.fasttrackit.nationsmatch.service.UserService;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser_whenValidRequest_thenUserIsSaved() {
		createUser();
	}

	@Test(expected = TransactionSystemException.class)
    public void testCreateUser_whenInvalidRequest_throwException() {
        SaveUserRequest request = new SaveUserRequest();
        userService.createUser(request);
    }

    @Test
	public void testGetUser_whenExistingUser_thenReturnUser() {
		User createdUser = createUser();
		User retrievedUser = userService.getUser(createdUser.getId());

		assertThat(retrievedUser, notNullValue());
		assertThat(retrievedUser.getId(), is(createdUser.getId()));
		assertThat(retrievedUser.getFirstName(), is(createdUser.getFirstName()));
		assertThat(retrievedUser.getLastName(), is(createdUser.getLastName()));
		assertThat(retrievedUser.getNationality(), is(createdUser.getNationality()));
		assertThat(retrievedUser.getAge(), is(createdUser.getAge()));
		assertThat(retrievedUser.getDescription(), is(createdUser.getDescription()));
	}

	private User createUser() {
		SaveUserRequest request = new SaveUserRequest();
		request.setFirstName("Paul");
		request.setLastName("Oltean");
		request.setAge(25);
		request.setDescription("Hard worker, but not workaholic");
		request.setNationality("Romanian");

		User createdUser = userService.createUser(request);

		assertThat(createdUser, notNullValue());
		assertThat(createdUser.getId(), notNullValue());
		assertThat(createdUser.getId(), greaterThan(0L));
		assertThat(createdUser.getFirstName(), is(request.getFirstName()));
		assertThat(createdUser.getLastName(), is(request.getLastName()));
		assertThat(createdUser.getAge(), is(request.getAge()));
		assertThat(createdUser.getDescription(), is(request.getDescription()));
		assertThat(createdUser.getNationality(), is(request.getNationality()));
		return createdUser;
	}
}
