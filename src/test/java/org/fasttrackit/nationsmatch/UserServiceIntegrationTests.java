package org.fasttrackit.nationsmatch;

import org.fasttrackit.nationsmatch.domain.User;
import org.fasttrackit.nationsmatch.service.UserService;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
class UserServiceIntegrationTests {

	@Autowired
	private UserService userService;

	@Test
	void testCreateUser_whenValidRequest_thenUserIsSaved() {
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
	}

}
