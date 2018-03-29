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
						<li><a href="/withdraw"><span>회원탈퇴</span></a></li>
					</ul>
				</div>
			</div>
		</div>

		<hr class="hide" />
		<div id="content" role="main">
			<div>
				<div>
					<div class="dimmed_layer" style="display: none"></div>
					<h2 id="body">회원탈퇴 안내동의 본문</h2>
					<div class="myinfo_intro intro_out">
						<span></span>
						<div class="cont_intro">
							<h3 class="withdraw_agree">회원탈퇴에 앞서 유의사항 및 안내를 반드시 읽고 진행해
								주세요!</h3>
						</div>
					</div>
					<form action="withdraw?action=agree-check" method="post">
						<fieldset class="fld_comm">
						<div class="info_agree">

							<div class="info_user">
								<strong>아이디 복구 불가 안내</strong> 
								<div class="info_text">
								<span class="txt_agree">회원탈퇴
									진행 시 본인을 포함한 타인 모두 <em>기존 아이디의 복구가 불가능합니다.</em><br> 신중히
									선택하신 후 결정해주세요.
								</span> <span class="check_notice"> <input type="checkbox"
									id="idAgree" name="idAgree" class="tf_check"> <label
									for="idAgree" class="lab_check"> <span></span> 동의
								</label>
								</span>
								</div>
							</div>

							<div class="info_user">
								<strong>내정보 및 개인형 서비스 이용 기록 삭제 안내</strong> 								<div class="info_text">
<span
									class="txt_agree">내정보 및 개인형 서비스 이용기록이 모두 삭제되며,<em>삭제된
										데이터는 복구되지 않습니다.</em>삭제되는 서비스를 확인하시고, 필요한 데이터는 미리 백업을 해주세요.<br>
								</span>
								<dl class="list_agree">
									<dt>
										<a href="http://blog.answer.is/" class="link_service">블로그</a>
									</dt>
									<dd>블로그 계정 및 포스팅 게시글 삭제</dd>
								</dl>
								<span class="check_notice"> <input type="checkbox"
									id="serviceAgree" name="serviceAgree" class="tf_check">
									<label for="serviceAgree" class="lab_check"> <span></span>
										동의
								</label>
								</span>
								</div>
							</div>

							<div class="info_user">
								<strong class="tit_agree">게시판형 서비스에 등록한 게시글 삭제 불가 안내</strong> <span
									class="txt_agree">삭제를 원하는 게시글이 있다면 반드시 회원탈퇴 전 비공개 처리하거나
									삭제하시기 바랍니다.<br>탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, <em
									class="emph_g">게시글을 임의로 삭제해드릴 수 없습니다.</em><br>
								</span>
								<dl class="list_agree">
									<dt class="tit_service">
										<a href="http://codelet.answer.is/" class="link_service">코드릿</a>
									</dt>
									<dd class="txt_service">작성한 코드릿</dd>
									<dt class="tit_service">
										<a href="http://qna.answer.is/" class="link_service">질문 및
											답변</a>
									</dt>
									<dd class="txt_service">질문 및 답변</dd>
								</dl>
								<span class="check_notice"> <input type="checkbox"
									id="boardAgree" name="boardAgree" class="tf_check"> <label
									for="boardAgree" class="lab_check"> <span
										class="ico_comm ico_check"></span> 동의
								</label>
								</span>
							</div>
						</div>
						<div class="wrap_btn">
							<a href="basic" class="btn_comm btn_cancel"><span
								class="screen_out">탈퇴 취소</span></a>
							<button type="submit" class="btn_comm btn_next">
								<span>다음 단계</span>
							</button>
						</div>
						</fieldset>
					</form>

					<!-- 회원탈퇴_안내동의 팝업 -->
					<div id="wrongLayer" class="userinfo_layer"
						style="top: 300px; margin-left: -188px; display: none;">
						<div class="inner_myinfo_layer">
							<div class="layer_head">
								<strong>회원탈퇴 안내동의 레이어</strong>
							</div>
							<div class="layer_body">
								<strong class="tit_layer">안내사항을 확인하신 후, 동의해 주세요.</strong>
								<div class="btn_process">
									<button type="button" class="btn_comm btn_ok">
										<span>확인</span>
									</button>
								</div>
							</div>
							<div class="layer_foot">
								<button type="button" class="btn_comm btn_close">닫기</button>
							</div>
						</div>
					</div>

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
