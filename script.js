document.getElementById('certificateForm').addEventListener('submit', function(e) {
  e.preventDefault();

  var name = document.getElementById('name').value;
  var courseName = document.getElementById('courseName').value;
 
  var designation = document.getElementById('designation').value;

  var certificateContent = `
    <p>This is to certify that <strong>${name}</strong> has worked as a <strong>${designation}</strong> at <strong>${courseName}</strong> .</p>
    <p>During their tenure, they have demonstrated excellent performance and contributed significantly to the success of their career Growth.</p>
    <p>We wish them all the best in their future to try hard.</p>
  `;

  document.getElementById('certificateContent').innerHTML = certificateContent;
  document.getElementById('certificateOutput').classList.remove('hidden');
  document.getElementById('downloadBtn').classList.remove('hidden');
});

document.getElementById('downloadBtn').addEventListener('click', function() {
  var certificateText = document.getElementById('certificateContent').imageContent;
  var blob = new Blob([certificateText], { type: 'jpg' });
 
  var link = document.getElementById('downloadLink');

  link.href = image;
  link.download = 'certificate.jpg';
  link.click();
});/**
 * 
 */