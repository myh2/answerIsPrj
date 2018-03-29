<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main id="main">
	<div class="bg_dimmed" style="display: none;"></div>
	<div id="wrap" class="withdraw">
		<div id="head" role="banner">
			<div class="inner_head">
				<h1>
					<a href="basic" id="serviceLogo"><span class="ir_wa">내
							정보 관리</span></a>
				</h1>

				<!-- PC 웹 내정보 GNB -->
				<div class="navigation">
					<h2>내정보 메인메뉴</h2>
					<ul>
						<li><a href="basic"><span>내 정보 관리</span></a></li>
						<li><a href="change-password"><span>비밀번호 변경</span></a></li>
					</ul>
					<ul>
						<li><a href="withdraw"><span>회원탈퇴</span></a></li>
					</ul>
				</div>
			</div>
		</div>

		<hr class="hide" />
		<div id="content" role="main">
			<div>
				<div>
					<h2 id="body">회원탈퇴 별도해지서비스 본문</h2>
					<div>
						<span></span>
						<div class="cont_intro">
							<h3 class="withdraw_agree">안전한 회원탈퇴를 위해, 비밀번호를 확인해 주세요.</h3>
							<p>
								비밀번호 확인 후 아이디는 즉시 탈퇴됩니다.<br> 탈퇴 후에는 동일 아이디로 다시 가입할 수 없으며
								아이디와 데이터는 복구할 수 없으니 신중하게 선택해 주세요.
							</p>
						</div>
					</div>
					<form action="withdraw?action=password-reconfirm"
						method="post">
						<fieldset class="fld_comm">
							<legend>비밀번호 재확인 입력 폼</legend>
							<div class="info_comm">
								<div class="info_detail info_id">
									<div>
										<strong>아이디</strong>
									</div>
									<div class="input_info input_id">kakakkaka@gmail.com</div>
								</div>
								<div class="info_detail info_pwreconfirm">
									<div>
										<strong>비밀번호</strong>
									</div>
									<div class="input_info">
										<div class="bg_user bg_basic">
											<label for="reconfirmPassword">비밀번호 입력</label>
											<input type="password" id="reconfirmPassword"
												name="reconfirmPassword"> <input
												type="text" id="textReconfirmPassword"
												style="display: none;" name="textReconfirmPassword">
										</div>
										<p class="desc_add emph_notice" style="display: none;"></p>
									</div>
								</div>
							</div>
							<div class="wrap_btn">
								<a href="basic" class="btn_comm btn_cancel"><span>탈퇴 취소</span></a>
								<button type="submit" class="btn_comm btn_confirm">
									<span>확인</span>
								</button>
							</div>
						</fieldset>
					</form>
				</div>
				<!--// mArticle -->
			</div>
			<!-- // cMain -->
		</div>
		<!-- // Content -->
		<hr class="hide">
		<div id="foot" class="footer_comm" role="contentinfo">
			<h2>서비스 이용정보</h2>
			<small class="txt_copyright">Copyright &#169; <a
				href="http://www.answer.is" class="link" style="font-weight: bold">Answer.is</a>
				All rights reserved.
			</small>
		</div>
		<!-- // Foot -->

		<div id="wrap"></div>
	</div>

</main>