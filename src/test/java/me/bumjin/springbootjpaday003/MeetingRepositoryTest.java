package me.bumjin.springbootjpaday003;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeetingRepositoryTest {

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void di() {
        assertThat(meetingRepository).isNotNull();
    }

    @Test
    public void findByTitle() {
        Meeting meeting = new Meeting();
        meeting.setTitle("bumjin");
        meeting.setContent("spring");

        meetingRepository.save(meeting) ;

        List<Meeting> result = meetingRepository.findByTitleIsLikeIgnoreCase("%BUm%");
        assertThat(result).hasSize(1);
    }

}