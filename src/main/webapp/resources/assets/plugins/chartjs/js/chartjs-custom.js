$(function () {
	"use strict";
	// chart 1
	var ctx = document.getElementById("chart1");
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ['8月15日', '8月16日', '8月17日', '8月18日', '8月19日', '8月20日'],
			datasets: [{
				label: '发生器',
				data: [13,31,20,3,6,20],
				barPercentage: .5,
				backgroundColor: "#673ab7"
			}, {
				label: '救生衣',
				data: [30,20,10,5,6,10],
				barPercentage: .5,
				backgroundColor: "#bf9bff"
			},{
				label: '传感器',
				data: [10,11,12,16,19,10],
				barPercentage: .5,
				backgroundColor: "#673ab7"
			},{
				label: '飞机导线',
				data: [4,6,7,13,15,21],
				barPercentage: .5,
				backgroundColor: "#32ab13"
			},{
				label: '电插头',
				data: [21,10,23,6,9,10],
				barPercentage: .5,
				backgroundColor: "#f02769"
			},{
				label: '转化器',
				data: [6,8,19,21,19,29],
				barPercentage: .5,
				backgroundColor: "#ffc107"
			}]
		},
		options: {
			maintainAspectRatio: false,
			legend: {
				display: true,
				labels: {
					fontColor: '#585757',
					boxWidth: 40
				}
			},
			tooltips: {
				enabled: true
			},
			scales: {
				xAxes: [{
					ticks: {
						beginAtZero: true,
						fontColor: '#585757'
					},
					gridLines: {
						display: true,
						color: "rgba(0, 0, 0, 0.07)"
					},
				}],
				yAxes: [{
					ticks: {
						beginAtZero: true,
						fontColor: '#585757'
					},
					gridLines: {
						display: true,
						color: "rgba(0, 0, 0, 0.07)"
					},
				}]
			}
		}
	});
	// chart 3
	new Chart(document.getElementById("chart3"), {
		type: 'pie',
		data: {
			labels: ["飞机导线", "救生衣", "电插头", "支柱充气工具", "数据显示压力表"],
			datasets: [{
				label: "Population (millions)",
				backgroundColor: ["#673ab7", "#32ab13", "#f02769", "#ffc107", "#198fed"],
				data: [2478, 5267, 734, 784, 433]
			}]
		},
		options: {
			maintainAspectRatio: false,
			title: {
				display: true,
				text: '各零部件使用占比分析图'
			}
		}
	});
	// chart 4
	// new Chart(document.getElementById("chart4"), {
	// 	type: 'radar',
	// 	data: {
	// 		labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
	// 		datasets: [{
	// 			label: "1950",
	// 			fill: true,
	// 			backgroundColor: "rgba(179,181,198,0.2)",
	// 			borderColor: "rgba(179,181,198,1)",
	// 			pointBorderColor: "#fff",
	// 			pointBackgroundColor: "rgba(179,181,198,1)",
	// 			data: [8.77, 55.61, 21.69, 6.62, 6.82]
	// 		}, {
	// 			label: "2050",
	// 			fill: true,
	// 			backgroundColor: "rgba(255,99,132,0.2)",
	// 			borderColor: "rgba(255,99,132,1)",
	// 			pointBorderColor: "#fff",
	// 			pointBackgroundColor: "rgba(255,99,132,1)",
	// 			pointBorderColor: "#fff",
	// 			data: [25.48, 54.16, 7.61, 8.06, 4.45]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		title: {
	// 			display: true,
	// 			text: 'Distribution in % of world population'
	// 		}
	// 	}
	// });
	// // chart 5
	// new Chart(document.getElementById("chart5"), {
	// 	type: 'polarArea',
	// 	data: {
	// 		labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
	// 		datasets: [{
	// 			label: "Population (millions)",
	// 			backgroundColor: ["#673ab7", "#32ab13", "#f02769", "#ffc107", "#198fed"],
	// 			data: [2478, 5267, 734, 784, 433]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		title: {
	// 			display: true,
	// 			text: 'Predicted world population (millions) in 2050'
	// 		}
	// 	}
	// });
	// // chart 6
	// new Chart(document.getElementById("chart6"), {
	// 	type: 'doughnut',
	// 	data: {
	// 		labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
	// 		datasets: [{
	// 			label: "Population (millions)",
	// 			backgroundColor: ["#673ab7", "#32ab13", "#f02769", "#ffc107", "#198fed"],
	// 			data: [2478, 5267, 734, 784, 433]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		title: {
	// 			display: true,
	// 			text: 'Predicted world population (millions) in 2050'
	// 		}
	// 	}
	// });
	// // chart 7
	// new Chart(document.getElementById("chart7"), {
	// 	type: 'horizontalBar',
	// 	data: {
	// 		labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
	// 		datasets: [{
	// 			label: "Population (millions)",
	// 			backgroundColor: ["#673ab7", "#32ab13", "#f02769", "#ffc107", "#198fed"],
	// 			data: [2478, 5267, 734, 784, 433]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		legend: {
	// 			display: false
	// 		},
	// 		title: {
	// 			display: true,
	// 			text: 'Predicted world population (millions) in 2050'
	// 		}
	// 	}
	// });
	// chart 8
	new Chart(document.getElementById("chart8"), {
		type: 'bar',
		data: {
			labels: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月','十月','十一月','十二月'],
			datasets: [{
				label: "三个月后过期",
				backgroundColor: "#F9F70B",
				data: [133, 221, 783, 500,700,300,288,588,358,678,900,1520]
			}, {
				label: "一年及一年以上过期",
				backgroundColor: "#32ab13",
				data: [408, 547, 675, 734,238,677,489,392,183,384,789,1000]
			},{
				label: "一个月后过期",
				backgroundColor: "#f02769",
				data: [300,278,564,209,833,688,722,309,490,734,852,900]
			}]
		},
		options: {
			maintainAspectRatio: false,
			title: {
				display: true,
				text: '单位: 件(数)'
			}
		}
	});
	// // chart 9
	// new Chart(document.getElementById("chart9"), {
	// 	type: 'bar',
	// 	data: {
	// 		labels: ["1900", "1950", "1999", "2050"],
	// 		datasets: [{
	// 			label: "Europe",
	// 			type: "line",
	// 			borderColor: "#673ab7",
	// 			data: [408, 547, 675, 734],
	// 			fill: false
	// 		}, {
	// 			label: "Africa",
	// 			type: "line",
	// 			borderColor: "#f02769",
	// 			data: [133, 221, 783, 2478],
	// 			fill: false
	// 		}, {
	// 			label: "Europe",
	// 			type: "bar",
	// 			backgroundColor: "rgba(0,0,0,0.2)",
	// 			data: [408, 547, 675, 734],
	// 		}, {
	// 			label: "Africa",
	// 			type: "bar",
	// 			backgroundColor: "rgba(0,0,0,0.2)",
	// 			backgroundColorHover: "#3e95cd",
	// 			data: [133, 221, 783, 2478]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		title: {
	// 			display: true,
	// 			text: 'Population growth (millions): Europe & Africa'
	// 		},
	// 		legend: {
	// 			display: false
	// 		}
	// 	}
	// });
	// // chart 10
	// new Chart(document.getElementById("chart10"), {
	// 	type: 'bubble',
	// 	data: {
	// 		labels: "Africa",
	// 		datasets: [{
	// 			label: ["China"],
	// 			backgroundColor: "#673ab7",
	// 			borderColor: "#673ab7",
	// 			data: [{
	// 				x: 21269017,
	// 				y: 5.245,
	// 				r: 15
	// 			}]
	// 		}, {
	// 			label: ["Denmark"],
	// 			backgroundColor: "#198fed",
	// 			borderColor: "#198fed",
	// 			data: [{
	// 				x: 258702,
	// 				y: 7.526,
	// 				r: 10
	// 			}]
	// 		}, {
	// 			label: ["Germany"],
	// 			backgroundColor: "#ffc107",
	// 			borderColor: "#ffc107",
	// 			data: [{
	// 				x: 3979083,
	// 				y: 6.994,
	// 				r: 15
	// 			}]
	// 		}, {
	// 			label: ["Japan"],
	// 			backgroundColor: "#f02769",
	// 			borderColor: "#f02769",
	// 			data: [{
	// 				x: 4931877,
	// 				y: 5.921,
	// 				r: 15
	// 			}]
	// 		}]
	// 	},
	// 	options: {
	// 		maintainAspectRatio: false,
	// 		title: {
	// 			display: true,
	// 			text: 'Predicted world population (millions) in 2050'
	// 		},
	// 		scales: {
	// 			yAxes: [{
	// 				scaleLabel: {
	// 					display: true,
	// 					labelString: "Happiness"
	// 				}
	// 			}],
	// 			xAxes: [{
	// 				scaleLabel: {
	// 					display: true,
	// 					labelString: "GDP (PPP)"
	// 				}
	// 			}]
	// 		}
	// 	}
	// });
});