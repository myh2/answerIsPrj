<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main id="main">

	<div>
		<div>
			<h1>
				<a href="/home" id="serviceLogo"><span>내 정보</span></a>
			</h1>

			<!-- PC 웹 내정보 GNB -->
			<div>
				<h2>내정보 메인메뉴</h2>
				<ul>
					<li><a href="my-info"><span>내정보 관리</span></a></li>
					<li><a href="change-password"><span>비밀번호 변경</span></a></li>
				</ul>
				<ul>
					<li><a href="withdraw"><span>회원탈퇴</span></a></li>
				</ul>
			</div>
		</div>
	</div>

	<hr class="hide" />
	<div id="content">
		<div>
			<div>
				<h2>비밀번호 변경 본문</h2>

				<div>
					<span></span>

					<div>
						<h3>주기적인(6개월) 비밀번호 변경을 통해 개인정보를
							안전하게 보호하세요.</h3>
					</div>
				</div>
				<form id="changePasswordForm"
					action="change-password?action=complete" method="post">
					<fieldset class="fld_comm">
						<legend>비밀번호 재확인 입력 폼</legend>
						<div>
							<div>
								<div>
									<strong>현재 비밀번호</strong>
								</div>
								<div>
									<div>
										<label for="password" class="lab_g">현재 비밀번호를 입력해 주세요.</label>
										<input type="password" id="password" name="password" value=""> <input type="text"
											title="입력한 비밀번호 보기" id="textPassword" name="textPassword"
											style="display: none">
										<button type="button" id="oldPasswordShow">
											<span>입력한 비밀번호 보기</span>
										</button>
									</div>
									<p style="display: none"></p>
								</div>
							</div>
							<div>
								<div>
									<strong>새 비밀번호</strong>
								</div>
								<div>
									<div>
										<label for="newPassword">새 비밀번호를 입력해
											주세요.</label> <input type="password" id="newPassword"
											name="newPassword" value=""> <input
											type="text" title="입력한 비밀번호 보기" id="textPwNew"
											name="textNewPassword" style="display: none">
										<button type="button" id="passwordShow">
											<span>입력한 비밀번호 보기</span>
										</button>
									</div>
									<p style="display: none"></p>
								</div>
							</div>
							<div>
								<div>
									<strong>새 비밀번호 TIP 리스트</strong> <em>TIP</em>

									<div>
										<ul>
											<li>비밀번호는 8~32자의 영문 대/소문자, 숫자, 특수문자를 조합하여 사용하실 수 있어요!</li>
											<li>쉬운 비밀번호나 자주 쓰는 사이트의 비밀번호가 같을 경우,도용되기 쉬워 주기적으로변경하여
												사용하는 것이 좋습니다.</li>
											<li>비밀번호에 특수문자를 추가하여 사용하시면 기억하기도 쉽고, 비밀번호 안전도가 높아져 도용의
												위험이 줄어듭니다.</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="wrap_btn">
							<a href="basic" class="btn_comm link_prev"><span>이전으로</span></a>
							<button type="button" class="btn_comm btn_save">
								<span>저장</span>
							</button>
						</div>
					</fieldset>
					<input type="hidden" id="PAGEID" name="PAGEID" value="" />
				</form>
			</div>
			<!--// mArticle -->
		</div>
		<!-- // cMain -->
	</div>
	<!-- // content -->
	<hr class="hide">
	<div id="foot" class="footer_comm" role="contentinfo">
		<h2 class="screen_out">서비스 이용정보</h2>
		<small class="txt_copyright">Copyright &#169; <a
			href="http://www.answer.is" class="link" style="font-weight: bold">Answer.is</a>
			All rights reserved.
		</small>
	</div>

	<div id="wrap"></div>
	</div>
</main>
