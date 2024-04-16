package edu.sejong.ex.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import edu.sejong.ex.page.Criteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageVO {

	private int startPage;
	private int endPage;

	private boolean pre, next;
	private int totoal;
	private Criteria criteria;

	public PageVO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.totoal = total;

		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		// Total을 통한 endPage의 재계산
		// 10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝번호는 10이 아닌 8이 됨
		int realEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));

		if (realEnd <= this.endPage) {
			this.endPage = realEnd;

		}

		this.pre = this.startPage > 1;
		this.next = this.endPage < realEnd;

	}

	public String makeQuery(int page) {

		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum
																											// =// 3
				.queryParam("amount", criteria.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10

		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴
	}

}
