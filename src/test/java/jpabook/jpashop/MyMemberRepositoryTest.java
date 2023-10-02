package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MyMemberRepositoryTest {

    @Autowired MyMemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception {
        //given
        MyMember myMember = new MyMember();
        myMember.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(myMember);
        MyMember findMyMember = memberRepository.find(savedId);

        //then
        assertThat(findMyMember.getId()).isEqualTo(myMember.getId());
        assertThat(findMyMember.getUsername()).isEqualTo(myMember.getUsername());
        assertThat(findMyMember).isEqualTo(myMember);
    }
}