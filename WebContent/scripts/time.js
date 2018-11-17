
			var canvas = document.getElementById("canvas");
			var context = canvas.getContext("2d");
			var w = canvas.width;//��ȡcanvas�����Ŀ��
			var h = canvas.height;//��ȡcanvas�����ĸ߶�
			var radius = 7;//����С��İ뾶
			var padd = 10;//��������֮��ļ��
			var balls = [];//�����ɫС��
			var u = 0.65;//С�����ײ������ʧϵ��
			var currentNums = [];//���浱ǰ��Ļ��8������
			var digit =
					[
						[
							[0,0,1,1,1,0,0],
							[0,1,1,0,1,1,0],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,0,1,1,0],
							[0,0,1,1,1,0,0]
						],//0
						[
							[0,0,0,1,1,0,0],
							[0,1,1,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[1,1,1,1,1,1,1]
						],//1
						[
							[0,1,1,1,1,1,0],
							[1,1,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,0,0],
							[0,0,1,1,0,0,0],
							[0,1,1,0,0,0,0],
							[1,1,0,0,0,0,0],
							[1,1,0,0,0,1,1],
							[1,1,1,1,1,1,1]
						],//2
						[
							[1,1,1,1,1,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,0,0],
							[0,0,1,1,1,0,0],
							[0,0,0,0,1,1,0],
							[0,0,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,1,1,0]
						],//3
						[
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,1,0],
							[0,0,1,1,1,1,0],
							[0,1,1,0,1,1,0],
							[1,1,0,0,1,1,0],
							[1,1,1,1,1,1,1],
							[0,0,0,0,1,1,0],
							[0,0,0,0,1,1,0],
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,1,1]
						],//4
						[
							[1,1,1,1,1,1,1],
							[1,1,0,0,0,0,0],
							[1,1,0,0,0,0,0],
							[1,1,1,1,1,1,0],
							[0,0,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,1,1,0]
						],//5
						[
							[0,0,0,0,1,1,0],
							[0,0,1,1,0,0,0],
							[0,1,1,0,0,0,0],
							[1,1,0,0,0,0,0],
							[1,1,0,1,1,1,0],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,1,1,0]
						],//6
						[
							[1,1,1,1,1,1,1],
							[1,1,0,0,0,1,1],
							[0,0,0,0,1,1,0],
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,0,0],
							[0,0,0,1,1,0,0],
							[0,0,1,1,0,0,0],
							[0,0,1,1,0,0,0],
							[0,0,1,1,0,0,0],
							[0,0,1,1,0,0,0]
						],//7
						[
							[0,1,1,1,1,1,0],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,1,1,0],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,1,1,0]
						],//8
						[
							[0,1,1,1,1,1,0],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[1,1,0,0,0,1,1],
							[0,1,1,1,0,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,0,1,1],
							[0,0,0,0,1,1,0],
							[0,0,0,1,1,0,0],
							[0,1,1,0,0,0,0]
						],//9
						[
							[0,0,0,0],
							[0,0,0,0],
							[0,1,1,0],
							[0,1,1,0],
							[0,0,0,0],
							[0,0,0,0],
							[0,1,1,0],
							[0,1,1,0],
							[0,0,0,0],
							[0,0,0,0]
						]//:
					];
			//����ʱ������� 
			function drawDatetime(cxt){
				var nums = [];
				var offsetX = 70;
				var offsetY = 30;
				var date = new Date();
				//��ȡСʱ�����ֺ������������
				var hours = date.getHours();
				var num1 = Math.floor(hours/10);
				var num2 = hours%10;
				nums.push({num:num1});
				nums.push({num:num2});
				nums.push({num:10});//ð��
				//��ȡ�ֵ����ֺ������������
				var min = date.getMinutes();
				var num1 = Math.floor(min/10);
				var num2 = min%10;
				nums.push({num:num1});
				nums.push({num:num2});
				nums.push({num:10});//ð��
				//��ȡ������ֺ������������
				var sec = date.getSeconds();
				var num1 = Math.floor(sec/10);
				var num2 = sec%10;
				nums.push({num:num1});
				nums.push({num:num2});
				
				for(var x=0;x<nums.length;x++ ){
					nums[x].offsetX = offsetX;
					offsetX = drawNumber(offsetX,offsetY,nums[x].num,cxt);
					//����������������һ��Ӧ����һ���ļ��
					if(x<nums.length-1){
						if((nums[x].num!=10) && (nums[x+1].num!=10)){
							offsetX += padd;
						}
					}
				}

				if(currentNums.length == 0){
					currentNums = nums;
				}else{
					for(var i = 0;i<currentNums.length;i++){
						if(currentNums[i].num != nums[i].num){
							addBalls(nums[i]);//��Ӳ�ɫС��
							currentNums[i].num = nums[i].num;
						}
					}
				}
				//���Ƴ���ɫС��
				drawBalls(cxt);
				//�Ƴ�С�� 
				moveBalls();
				
				//return date;
		}
			//��������
			function drawNumber(offsetX,offsetY,num,cxt){
				var numMatrix = digit[num];
				context.fillStyle = "#6666ff";
				for(var y=0;y<numMatrix.length;y++){
					for(var x=0;x<numMatrix[y].length;x++){
						if(numMatrix[y][x]==1){
							cxt.beginPath();
							
cxt.arc(offsetX+radius+radius*2*x,offsetY+radius+radius*2*y,radius,0,360,false)
;
							cxt.fill();
						}
					}
				}
				offsetX += numMatrix[0].length*radius*2;
				return offsetX;
			}
			//��Ӳ�ɫС��
			function addBalls(item){
				var num = item.num;
				var numMatrix = digit[num]
				for(var y=0;y<numMatrix.length;y++){
					for(var x=0;x<numMatrix[y].length;x++){
						if(numMatrix[y][x]==1){
							var ball = {
								offsetX : item.offsetX+radius+radius*2*x,
								offsetY : 30+radius+radius*2*y,
								color : color(),
								sx : Math.pow(-1,Math.ceil(Math.random()*10))*4+Math.random(),
								sy : -5,
								g : 1.5+Math.random()
							}
							balls.push(ball);
						}
					}
				}
			}
			//���Ʋ�ɫС
			function drawBalls(cxt){
				for(var i = 0;i<balls.length;i++){
					cxt.beginPath();
					cxt.arc(balls[i].offsetX,balls[i].offsetY,radius,0,360,false);
					cxt.fillStyle = balls[i].color;
					cxt.fill();
				}

				
			}
			//�Ƴ���ɫС��
			function moveBalls(){
				var n = 0;
				for(var i=0;i<balls.length;i++){
					var ball = balls[i];
					ball.offsetX += ball.sx;
					ball.offsetY += ball.sy;
					ball.sy += ball.g;
					
					if(ball.offsetY > (h-radius)){
						ball.offsetY = h-radius;
						ball.sy = -ball.sy*u;
					}
					if(ball.offsetX > radius && ball.offsetX < (w-radius)){
						balls[n] = balls[i];
						n++;
					}
				}

				for(;n<balls.length;n++){
					balls.pop();//ɾ�������������е����һ��С��
				}

			}
			setInterval(function(){
				context.clearRect(0,0,w,h);
				drawDatetime(context);
			},50);
			//���������ɫ
			function color(){
				var _color= Math.ceil(Math.random()*16777215).toString(16);
				while(_color.length<6){
					_color += "0"+_color;
				}
				//console.log(_color);
				return "#"+_color
			}
			//���Ʋ�ɫС�� 
			//��ɫС���ƶ�����
			//��canvas	X�߽��ϵĲ�ɫС����ʧ
		